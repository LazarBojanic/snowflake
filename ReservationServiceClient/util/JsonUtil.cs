using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ReservationServiceClient.util {
    public static class JsonUtil {
        public static string serialize(object obj) {
            try {
                string json = JsonConvert.SerializeObject(
                                    obj,
                                    new JsonSerializerSettings {
                                        NullValueHandling = NullValueHandling.Ignore
                                    }
                                );
                return json;
            }
            catch (Exception ex) {
                return null;
            }
        }
        public static T deserialize<T>(string json) {
            try {
                T deserializedObject = JsonConvert.DeserializeObject<T>(
                                    json,
                                    new JsonSerializerSettings {
                                        NullValueHandling = NullValueHandling.Ignore
                                    }
                                );
                return deserializedObject;
            }
            catch(Exception ex) {
                return default(T);
            }
        }
    }
}
