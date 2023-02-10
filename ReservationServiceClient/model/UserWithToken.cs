using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReservationServiceClient.model {
    public class UserWithToken {
        public string email { get; set; }
        public string token { get; set; }
        public UserWithToken() { }

        public UserWithToken(string email, string token) {
            this.email = email;
            this.token = token;
        }
    }
}
