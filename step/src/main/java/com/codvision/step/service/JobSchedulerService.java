package com.codvision.step.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.codvision.step.utils.Logger;


/**
 *
 * Created by jiahongfei on 2017/10/13.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobSchedulerService extends JobService {

    private static final String TAG = "JobSchedulerService";

    @Override
    public boolean onStartJob(JobParameters params) {
        Intent intent = new Intent(getApplication(), StepService.class);
        getApplication().startService(intent);

//        Toast.makeText(getApplicationContext(), "onStartJob", Toast.LENGTH_SHORT).show();

        Logger.e(TAG,"onStartJob");

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
