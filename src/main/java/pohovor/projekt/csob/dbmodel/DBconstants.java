package pohovor.projekt.csob.dbmodel;

public class DBconstants {

    public static class TableNames {
        public static final String aircraft = "AIRCRAFT";
        public static final String airport = "AIRPORT";
        public static final String airportRunway = "AIRPORTRUNWAY";
        public static final String weather = "WEATHER";
        public static final String airportSlot = "AIRPORTSLOT";
        public static final String flyLog = "FLYLOG";
    }

    public static class Entity {
        public static final String id = "ID";
        public static final String creationDate = "CREATIONDATE";
    }

    public static class Aircraft {
        public static final String aircraftType = "AIRCRAFTTYPE";
        public static final String registrationDate = "REGISTRATIONDATE";
        public static final String registrationCountry = "REGISTRATIONCOUNTRY";
        public static final String serialNumber = "SERIALNUMBER";
        public static final String age = "AGE";
    }

    public static class Airport {
        public static final String hangarCapacity = "HANGARCAPACITY";
        public static final String runwayCapacity = "RUNWAYCAPACITY";
        public static final String airportType = "AIRPORTTYPE";
    }

    public static class Runway {
        public static final String endUse = "ENDUSE";
        public static final String isFree = "ISFREE";
        public static final String airport_id = "AIRPORT_ID";
    }

    public static class AirportSlot {
        public static final String airport_id = "AIRPORT_ID";
        public static final String aircraft_id = "AIRCRAFT_ID";
    }

    public static class FlyLog {
        public static final String flyType = "FLYTYPE";

    }

    public static class Weather {
        public static final String airport_id = "AIRPORT_ID";
        public static final String updateDate = "UPDATEDATE";
    }





}
