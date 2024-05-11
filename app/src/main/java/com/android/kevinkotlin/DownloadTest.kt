package com.android.kevinkotlin

import android.util.Log
import com.ijoysoft.download.DownloadListener
import com.ijoysoft.download.Downloader
import com.ijoysoft.download.IPathGenerator
import com.ijoysoft.download.IUrlGenerator
import com.ijoysoft.download.SingleDownloadRequest
import com.lb.library.ActivityLifecycle
import com.lb.library.executor.ExecutorFactory
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import java.io.FileOutputStream

/**
 * author : WanKai
 * date : 2024/5/10 10:51
 * description：
 */
class DownloadTest {
    companion object {

        private const val QQ_SPEED_URL =
            "https://gp-open-platform.cdn.bcebos.com/204404250955/d13fe74bb209e4ccc04ef9b7a0cedcb7/gp-open-platform/upload/file/apk/e11410eae2d13a5d1140f2f439089683.apk"
        private var SAVE = ActivityLifecycle.get().application.filesDir.path + "/QQSpeed.apk"

        private var preSize: Long = 0
        private var preMillis: Long = System.currentTimeMillis()

        fun downloadTest1() {
            preSize = 0
            preMillis = System.currentTimeMillis()

            val request = SingleDownloadRequest()
                .setUrl(QQ_SPEED_URL)
                .setUrlGenerator(IUrlGenerator {
                    QQ_SPEED_URL
                })
                .setPathGenerator(IPathGenerator {
                    SAVE
                })
                .setReload(Downloader.RELOAD_ALL)
                .setListener(object : DownloadListener {
                    override fun onDownloadStart(url: String?) {
                    }

                    override fun onDownloadEnd(url: String?, result: Int) {
                    }

                    override fun onDownloadProgress(
                        url: String?,
                        currentSize: Long,
                        totalSize: Long
                    ) {
                        val millis = System.currentTimeMillis()
                        val time = (millis - preMillis) / 1000.0
                        if (time >= 1) {
                            val size = (currentSize - preSize) / 1024.0 / 1024.0
                            val speed = String.format("%.2f", size / time)
                            val progress = String.format("%.2f", currentSize * 100.0 / totalSize)

                            Log.d("wankailog", speed + "M/S" + " 进度 = " + progress + "%")

                            preSize = currentSize
                            preMillis = millis
                        }
                    }
                })
                .setExecutor(ExecutorFactory.net())
            Downloader.load(request)
        }

        private var addTotalSize = 0

        fun downloadTest2() {
            ExecutorFactory.net().execute {
                preMillis = System.currentTimeMillis()
                val retrofit = Retrofit.Builder().baseUrl("http://www.httpbin.org/").build()
                val upLoadService = retrofit.create<UpLoadService>()
                val response: Response<ResponseBody> =
                    upLoadService.download(QQ_SPEED_URL).execute()
                val inputStream = response.body()!!.byteStream()
                val fos = FileOutputStream(SAVE)
                var len: Int
                val buffer = ByteArray(8196 * 4)
                while (inputStream.read(buffer).also { len = it } != -1) {
                    fos.write(buffer, 0, len)
                    val millis = System.currentTimeMillis()
                    val time = (millis - preMillis) / 1000.0
                    if (time >= 1) {
                        val size = addTotalSize / 1024.0 / 1024.0
                        val speed = String.format("%.2f", size / time)

                        Log.d("wankailog", speed + "M/S")

                        addTotalSize = 0
                        preMillis = millis
                    } else {
                        addTotalSize += buffer.size
                    }
                }
                fos.close()
                inputStream.close()
            }
        }
    }
}