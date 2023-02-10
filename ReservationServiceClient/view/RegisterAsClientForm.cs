using ReservationServiceClient.http;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ReservationServiceClient.view {
    public partial class RegisterAsClientForm : Form {
        public RegisterAsClientForm() {
            InitializeComponent();
        }

        private async void buttonRegister_Click(object sender, EventArgs e) {
            ClientUser clientUser = new ClientUser();

            if (!textBoxEmail.Text.Equals("")) {
                clientUser.email = textBoxEmail.Text;
            }
            if (!textBoxUsername.Text.Equals("")) {
                clientUser.username = textBoxUsername.Text;
            }
            if (textBoxPass.Text != "") {
                clientUser.pass = textBoxPass.Text;
            }
            if (!textBoxPhoneNumber.Text.Equals("")) {
                clientUser.phone_number = textBoxPhoneNumber.Text;
            }
            if (!dateTimePickerDateOfBirth.Value.Equals(new DateTime(1800, 1, 1))) {
                clientUser.date_of_birth = dateTimePickerDateOfBirth.Value;
            }
            if (!textBoxFirstName.Text.Equals("")) {
                clientUser.first_name = textBoxFirstName.Text;
            }
            if (!textBoxLastName.Text.Equals("")) {
                clientUser.last_name = textBoxLastName.Text;
            }
            if (!textBoxPassportNumber.Text.Equals("")) {
                clientUser.passport_number = Convert.ToInt32(textBoxPassportNumber.Text);
            }


            await RestClient.sendPost(clientUser, RestClient.USER_SERVICE_URL + "user/client/register", "null");


        }

        private void buttonCancel_Click(object sender, EventArgs e) {
            this.Close();
        }

        private void RegisterAsClientForm_Load(object sender, EventArgs e) {

        }
    }
}
