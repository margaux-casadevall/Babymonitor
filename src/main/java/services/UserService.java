package services;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.client.model.Filters;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import models.*;
import org.bson.conversions.Bson;

public class UserService {
    public static UserService Instance = new UserService();

    private final MongoCollection<User> users;

    public UserService(){
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        MongoClient client = MongoClients.create("mongodb+srv://admin:p6kVfdTfbMiluEW2@prematurebabymonitor.rpvimtk.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = client.getDatabase("BabyMonitor").withCodecRegistry(pojoCodecRegistry);

        users = database.getCollection("Users", User.class);
    }

    public void create(User user) {
        users.insertOne(user);
    }

    public User login(String username, String password) {
        Bson filter = Filters.and(Filters.eq("username", username), Filters.eq("password", password));

        User user = users.find(filter).first();

        return user;
    }
}