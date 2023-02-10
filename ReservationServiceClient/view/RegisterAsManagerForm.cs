using ReservationServiceClient.http;
using ReservationServiceClient.util;
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
    public partial class RegisterAsManagerForm : Form {
        public RegisterAsManagerForm() {
            InitializeComponent();
            
        }
        public async Task populateComboBoxFirms() {
            string firmListJson = await RestClient.sendGet(RestClient.RESERVATION_SERVICE_URL + "firm/getAll", RestClient.MASTER_TOKEN);
            List<Firm> firmNameList = JsonUtil.deserialize<List<Firm>>(firmListJson);
            comboBoxFirms.Items.Clear();
            foreach(Firm firm in firmNameList) {
                comboBoxFirms.Items.Add(firm.firm_name);
            }
            if(firmNameList.Count > 0) {
                comboBoxFirms.SelectedIndex = 0;
            }
        }

        private async void buttonRegister_Click(object sender, EventArgs e) {

            Firm firm = null;
            string firmJson = null;
            

            ManagerUser managerUser = new ManagerUser();

            if (!textBoxEmail.Text.Equals("")) {
                managerUser.email = textBoxEmail.Text;
            }
            if (!textBoxUsername.Text.Equals("")) {
                managerUser.username = textBoxUsername.Text;
            }
            if (textBoxPass.Text != "") {
                managerUser.pass = textBoxPass.Text;
            }
            if (!textBoxPhoneNumber.Text.Equals("")) {
                managerUser.phone_number = textBoxPhoneNumber.Text;
            }
            if (!dateTimePickerDateOfBirth.Value.Equals(new DateTime(1800, 1, 1))) {
                managerUser.date_of_birth = dateTimePickerDateOfBirth.Value;
            }
            if (!textBoxFirstName.Text.Equals("")) {
                managerUser.first_name = textBoxFirstName.Text;
            }
            if (!textBoxLastName.Text.Equals("")) {
                managerUser.last_name = textBoxLastName.Text;
            }
            if (!comboBoxFirms.SelectedItem.Equals("")) {
                firmJson = await RestClient.sendGet(RestClient.RESERVATION_SERVICE_URL + "firm/getByName/" + comboBoxFirms.SelectedText, RestClient.MASTER_TOKEN);
                firm = JsonUtil.deserialize<Firm>(firmJson);
                managerUser.firm_id = firm.id;
            }
            if (!dateTimePickerHireDate.Value.Equals(new DateTime(1800, 1, 1))) {
                managerUser.hire_date = dateTimePickerHireDate.Value;
            }

            await RestClient.sendPost(managerUser, RestClient.USER_SERVICE_URL + "user/manager/register", RestClient.MASTER_TOKEN);
        }

        private void buttonCancel_Click(object sender, EventArgs e) {
            this.Close();
        }

        private async void RegisterAsManagerForm_Load(object sender, EventArgs e) {
            await populateComboBoxFirms();
        }
    }
}
