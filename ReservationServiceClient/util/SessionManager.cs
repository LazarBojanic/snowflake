using ReservationServiceClient.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReservationServiceClient.util {
    public class SessionManager {
        private static object mutex = new object();
        private static SessionManager instance = null;
        public List<UserWithToken> userWithTokenList { get; set; }
        public ServiceUser currentUser { get; set; }

        private SessionManager() {
            userWithTokenList = new List<UserWithToken>();
            currentUser = null;
        }

        public static SessionManager getInstance() {
            if (instance is null){
                lock (mutex) {
                    if (instance is null) {
                        instance = new SessionManager();
                    }
                }
            }
            return instance;
        }
        public string getTokenOfCurrentUser() {
            foreach (UserWithToken userWithToken in userWithTokenList) {
                if (userWithToken.email.Equals(SessionManager.getInstance().currentUser.email)) {
                    return userWithToken.token;
                }
            }
            return null;
        }
    }
}
