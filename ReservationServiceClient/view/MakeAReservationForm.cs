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
    public partial class MakeAReservationForm : Form {
        private ClientUser clientUser;
        public MakeAReservationForm(ClientUser parClientUser) {
            InitializeComponent();
            this.clientUser = parClientUser;
        }

    }
}
