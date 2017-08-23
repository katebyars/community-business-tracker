import dao.Sql2oBusinessDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import com.google.gson.Gson;


public class App {

    public static void main(String[] args) {
        Sql2oBusinessDao businessDao;
        Sql2oEmployerDao employerDao;

    }
}





//    //CREATE
//    post("/restaurants/new", "application/json", (req, res) -> { //accept a request in format JSON from an app
//        Restaurant restaurant = gson.fromJson(req.body(), Restaurant.class); //make java from JSON with GSON
//        restaurantDao.add(restaurant); //Do our thing with our DAO
//        res.status(201);
//        return gson.toJson(restaurant); //send it back to be displayed
//    });
//    post("/foodtypes/new", "application/json", (req, res) ->{
//        Foodtype foodtype = gson.fromJson(req.body(), Foodtype.class);
//        foodtypeDao.add(foodtype);
//        res.status(201);
//        return gson.toJson(foodtype);
//}
//
///READ
//    get("/restaurants", "application/json", (req, res) -> { //accept a request in format JSON from an app
//        return gson.toJson(restaurantDao.getAll());//send it back to be displayed
//    });
//    get("/foodtypes", "application/json", (req, res) -> {
//        return gson.toJson(foodtypeDao.getAll());
//    });
