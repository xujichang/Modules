package com.codvision.checksdk.web;


import com.codvision.base.api.CommonApi;
import com.codvision.base.wrapper.wrapper.WrapperEntity;
import com.codvision.checksdk.web.ext.Files;
import com.github.lzyzsd.jsbridge.CallBackFunction;

import java.io.File;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.xujichang.util.retrofit.RetrofitManager;
import me.xujichang.util.tool.StringTool;

/**
 * Des:
 *
 * @author xjc
 * Created on 2017/12/4 16:20.
 */

public class SingleFileUpload {
    private String baseUrl;
    private File uploadFile;
    private CallBackFunction function;

    public SingleFileUpload withFile(String data) {
        uploadFile = new File(data);
        return this;
    }


    public SingleFileUpload withBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public SingleFileUpload withFunction(CallBackFunction function) {
        this.function = function;
        return this;
    }

    public void upload(CallBackFunction function) {
        this.function = function;
        upload();
    }

    public void upload() {
        if (!uploadFile.exists()) {
            function.onCallBack(DataType.createRespData(WebConst.StatusCode.ERROR_FILE_NOT_FOUND, "文件不存在", uploadFile.getName()));
            return;
        }
        uploadFile(uploadFile);
    }

    private void uploadFile(final File file) {
        function.onCallBack(DataType.createRespData(WebConst.StatusCode.STATUS_OK, "文件上传成功", "测试数据"));
//        Observer<WrapperEntity<String>> observer = new Observer<WrapperEntity<String>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(WrapperEntity<String> entity) {
//                if (entity.getCode() == 200) {
//                    function.onCallBack(DataType.createRespData(WebConst.StatusCode.STATUS_OK, "文件上传成功", entity.getData()));
//
//                } else {
//                    function.onCallBack(DataType.createRespData(entity.getCode(), WebConst.StatusCode.STATUS_SERVER_RESP, entity.getMessage(), uploadFile.getName()));
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                function.onCallBack(DataType.createRespData(WebConst.StatusCode.STATUS_ERROR, StringTool.getErrorMsg(e), uploadFile.getName()));
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//        RetrofitManager
//                .getOurInstance()
//                .createReq(CommonApi.class)
//                .uploadSingleFile(Files.fileToMultipartBodyPart(file))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
    }

    public SingleFileUpload withFile(File file) {
        uploadFile = file;
        return this;
    }
}
