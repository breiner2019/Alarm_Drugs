package com.example.alarm_drugs;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class AlarmDrugRepository {
    private AlarmDrugsDao alarmDrugsDao;
    private LiveData<List<AlarmDrugs>> allAlarm;

    public AlarmDrugRepository(Application application){
        AlarmDatabase database = AlarmDatabase.getInstance(application);
        alarmDrugsDao = database.AlarmDrugsDao();
        allAlarm= alarmDrugsDao.getAllAlarm();
    }

    public void insert(AlarmDrugs alarmDrugs){
        new InsertAlarmDrugAsyncTask(alarmDrugsDao).execute(alarmDrugs);
    }

    public void upgrade(AlarmDrugs alarmDrugs){
        new UpdateAlarmDrugAsyncTask(alarmDrugsDao).execute(alarmDrugs);
    }

    public void delete(AlarmDrugs alarmDrugs){
        new DeleteAlarmDrugAsyncTask(alarmDrugsDao).execute(alarmDrugs);
    }

    public void deleteAllAlarm(){
        new DeleteAllAlarmDrugAsyncTask(alarmDrugsDao).execute();
    }

    public LiveData<List<AlarmDrugs>> getAllAlarms (){
        return allAlarm;
    }

    private static class InsertAlarmDrugAsyncTask extends AsyncTask<AlarmDrugs, Void, Void>{

        private AlarmDrugsDao alarmDrugsDao;

        public InsertAlarmDrugAsyncTask(AlarmDrugsDao alarmDrugsDao) {
            this.alarmDrugsDao = alarmDrugsDao;
        }

        @Override
        protected Void doInBackground(AlarmDrugs... alarmDrugs) {
            alarmDrugsDao.Insert(alarmDrugs[0]);
            return null;
        }
    }

    private static class UpdateAlarmDrugAsyncTask extends AsyncTask<AlarmDrugs, Void, Void>{

        private AlarmDrugsDao alarmDrugsDao;

        public UpdateAlarmDrugAsyncTask(AlarmDrugsDao alarmDrugsDao) {
            this.alarmDrugsDao = alarmDrugsDao;
        }

        @Override
        protected Void doInBackground(AlarmDrugs... alarmDrugs) {
            alarmDrugsDao.Update(alarmDrugs[0]);
            return null;
        }
    }

    private static class DeleteAlarmDrugAsyncTask extends AsyncTask<AlarmDrugs, Void, Void>{

        private AlarmDrugsDao alarmDrugsDao;

        public DeleteAlarmDrugAsyncTask(AlarmDrugsDao alarmDrugsDao) {
            this.alarmDrugsDao = alarmDrugsDao;
        }

        @Override
        protected Void doInBackground(AlarmDrugs... alarmDrugs) {
            alarmDrugsDao.Delete(alarmDrugs[0]);
            return null;
        }
    }

    private static class DeleteAllAlarmDrugAsyncTask extends AsyncTask<Void, Void, Void>{

        private AlarmDrugsDao alarmDrugsDao;

        public DeleteAllAlarmDrugAsyncTask(AlarmDrugsDao alarmDrugsDao) {
            this.alarmDrugsDao = alarmDrugsDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            alarmDrugsDao.deleteAllAlarm();
            return null;
        }
    }
}
