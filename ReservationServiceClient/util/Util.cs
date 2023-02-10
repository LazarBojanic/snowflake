using ReservationServiceClient.http;
using ReservationServiceClient.model;
using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReservationServiceClient.util {
    public static class Util {
        private static JwtSecurityTokenHandler jwtSecurityTokenHandler = new JwtSecurityTokenHandler();
        /*public static string getAllReservationsForUser(long userId) {
            try {
                string
                string allReservationsJson = RestClient.sendGet(RestClient.RESERVATION_SERVICE_URL + "")
            }
            catch(Exception ex) {
                return null;
            }
        }*/
        public static JwtSecurityToken decodeToken(string tokenString) {
            return jwtSecurityTokenHandler.ReadJwtToken(tokenString);
        }
        public static string getTokenClaimsValue(JwtSecurityToken decodedToken, string valueType) {
            return decodedToken.Claims.First(claim => claim.Type == valueType).Value;
        }
        public static List<ReviewJoined> reviewViewListToReviewJoinedList(List<ReviewView> reviewViewList) {
            List<ReviewJoined> reviewJoinedList = new List<ReviewJoined>();
            foreach(ReviewView reviewView in reviewViewList) {
                reviewJoinedList.Add(reviewViewToReviewJoined(reviewView));
            }
            return reviewJoinedList;
        }
        public static ReviewJoined reviewViewToReviewJoined(ReviewView reviewView) {
            ReviewJoined reviewJoined = new ReviewJoined();
            reviewJoined.id= reviewView.id;
            reviewJoined.client_user_id = reviewView.client_user_id;
            reviewJoined.firm_id = reviewView.firm.id;
            reviewJoined.firm_name= reviewView.firm.firm_name;
            reviewJoined.firm_city = reviewView.firm.city;
            reviewJoined.text = reviewView.text;
            reviewJoined.grade = reviewView.grade;
            return reviewJoined;
        }




        public static List<ReservationJoined> reservationViewListToReservationJoinedList(List<ReservationView> reservationViewList) {
            List<ReservationJoined> reservationJoinedList = new List<ReservationJoined>();
            foreach (ReservationView reservationView in reservationViewList) {
                reservationJoinedList.Add(reservationViewToReservationJoined(reservationView));
            }
            return reservationJoinedList;
        }
        public static ReservationJoined reservationViewToReservationJoined(ReservationView reservationView) {
            ReservationJoined reservationJoined = new ReservationJoined();

            reservationJoined.id= reservationView.id;
            reservationJoined.client_user_id = reservationView.client_user_id;
            reservationJoined.vehicle_in_firm_id = reservationView.vehicle_in_firm.id;
            reservationJoined.firm_id = reservationView.vehicle_in_firm.firm.id;
            reservationJoined.firm_name = reservationView.vehicle_in_firm.firm.firm_name;
            reservationJoined.firm_description = reservationView.vehicle_in_firm.firm.description;
            reservationJoined.firm_number_of_vehicles = reservationView.vehicle_in_firm.firm.number_of_vehicles;
            reservationJoined.firm_city = reservationView.vehicle_in_firm.firm.city;
            reservationJoined.vehicle_id = reservationView.vehicle_in_firm.vehicle.id;
            reservationJoined.vehicle_type_id = reservationView.vehicle_in_firm.vehicle.vehicle_type.id;
            reservationJoined.vehicle_type = reservationView.vehicle_in_firm.vehicle.vehicle_type.vehicle_type;
            reservationJoined.vehicle_model_id = reservationView.vehicle_in_firm.vehicle.vehicle_model.id;
            reservationJoined.vehicle_model = reservationView.vehicle_in_firm.vehicle.vehicle_model.vehicle_model;
            reservationJoined.vehicle_name = reservationView.vehicle_in_firm.vehicle.vehicle_name;
            reservationJoined.vehicle_production_year = reservationView.vehicle_in_firm.vehicle.production_year;
            reservationJoined.vehicle_horse_power = reservationView.vehicle_in_firm.vehicle.horse_power;
            reservationJoined.vehicle_in_firm_price = reservationView.vehicle_in_firm.price;
            reservationJoined.reservation_start_date = reservationView.start_date;
            reservationJoined.reservation_end_date = reservationView.end_date;

            return reservationJoined;
        }
    }
}
