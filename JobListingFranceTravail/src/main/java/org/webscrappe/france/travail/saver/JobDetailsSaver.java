package org.webscrappe.france.travail.saver;

import com.google.gson.reflect.TypeToken;
import org.webscrappe.france.travail.model.JobDetails;
import org.webscrappe.france.travail.jobdetailsdao.JobDetailsDao;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class JobDetailsSaver {

    private JobDetailsDao jobDetailsDao;

    public JobDetailsSaver() {
        this.jobDetailsDao = new JobDetailsDao();
    }

    public void saveJobDetails(List<JobDetails> jobDetailsList) {
        for (JobDetails jobDetails : jobDetailsList) {
            jobDetailsDao.createJobDetails(jobDetails);
        }
    }
    public void saveJobDetailsToJson(List<JobDetails> jobDetailsList) {
        Gson gson = new Gson();
        String json = gson.toJson(jobDetailsList);

        try (FileWriter writer = new FileWriter("src/main/java/org/webscrappe/france/travail/joblistingsdata/jobDetails.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}