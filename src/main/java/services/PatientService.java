package services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import models.Patient;
import models.User;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.util.ArrayList;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class PatientService {
    public static PatientService Instance = new PatientService();

    private final MongoCollection<Patient> patients;

    public PatientService(){
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        MongoClient client = MongoClients.create("mongodb+srv://admin:p6kVfdTfbMiluEW2@prematurebabymonitor.rpvimtk.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = client.getDatabase("BabyMonitor").withCodecRegistry(pojoCodecRegistry);

        patients = database.getCollection("Patients", Patient.class);
    }

    public ArrayList<Patient> list() {
        return patients.find().into(new ArrayList<>());
    }

    public Patient get(String id) {
        Bson filter = Filters.eq("id", id);

        Patient patient = patients.find(filter).first();

        return patient;
    }

    public void replace(String id, Patient patient) {
        Bson filter = Filters.eq("id", id);

        patients.replaceOne(filter, patient);
    }
}