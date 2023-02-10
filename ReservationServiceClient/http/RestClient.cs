using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace ReservationServiceClient.http {

    public static class RestClient {
        public static string USER_SERVICE_URL = "http://localhost:8083/userservice/api/";
        public static string RESERVATION_SERVICE_URL = "http://localhost:8083/reservationservice/api/";
        public static string NOTIFICATION_SERVICE_URL = "http://localhost:8083/notificationservice/api/";
        public static string MASTER_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjAiLCJyb2xlX2lkIjoiMCJ9.b4FxCueRVzuaJBUIQAwgcLyfkXwb8ZUfbYys34ZUD8I";
        public static HttpClient httpClient = new HttpClient();
        public static MediaTypeWithQualityHeaderValue contentType = MediaTypeWithQualityHeaderValue.Parse("application/json");
        public static async Task<string> sendGet(string url, string token) {
            httpClient.DefaultRequestHeaders.Accept.Add(contentType);
            httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", token);
            var response = await httpClient.GetAsync(url);
            var result = response.Content.ReadAsStringAsync();
            return result.Result;
        }
        public static async Task<string> sendPost(object data, string url, string token) {
            httpClient.DefaultRequestHeaders.Accept.Add(contentType);
            httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", token);
            var response = await httpClient.PostAsJsonAsync(new Uri(url), data);
            var result = response.Content.ReadAsStringAsync();
            return result.Result;
        }
        public static async Task<string> sendPut(object data, string url, string token) {
            httpClient.DefaultRequestHeaders.Accept.Add(contentType);
            httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", token);
            var response = await httpClient.PutAsJsonAsync(new Uri(url), data);
            var result = response.Content.ReadAsStringAsync();
            return result.Result;
        }
        public static async Task<string> sendDelete(object data, string url, string token) {
            httpClient.DefaultRequestHeaders.Accept.Add(contentType);
            httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", token);
            var response = await httpClient.DeleteAsync(url);
            var result = response.Content.ReadAsStringAsync();
            return result.Result;
        }
    }
}
