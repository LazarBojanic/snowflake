namespace ReservationServiceClient.view {
    partial class ClientHubForm {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing) {
            if (disposing && (components != null)) {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent() {
            this.buttonMakeAReservation = new System.Windows.Forms.Button();
            this.buttonEditProfile = new System.Windows.Forms.Button();
            this.labelUsername = new System.Windows.Forms.Label();
            this.dataGridViewReservations = new System.Windows.Forms.DataGridView();
            this.buttonViewStatus = new System.Windows.Forms.Button();
            this.buttonClose = new System.Windows.Forms.Button();
            this.buttonReviews = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewReservations)).BeginInit();
            this.SuspendLayout();
            // 
            // buttonMakeAReservation
            // 
            this.buttonMakeAReservation.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.buttonMakeAReservation.Font = new System.Drawing.Font("Century Gothic", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonMakeAReservation.Location = new System.Drawing.Point(12, 209);
            this.buttonMakeAReservation.Name = "buttonMakeAReservation";
            this.buttonMakeAReservation.Size = new System.Drawing.Size(198, 71);
            this.buttonMakeAReservation.TabIndex = 10;
            this.buttonMakeAReservation.Text = "Make A Reservation";
            this.buttonMakeAReservation.UseVisualStyleBackColor = true;
            this.buttonMakeAReservation.Click += new System.EventHandler(this.buttonMakeAReservation_Click);
            // 
            // buttonEditProfile
            // 
            this.buttonEditProfile.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.buttonEditProfile.Font = new System.Drawing.Font("Century Gothic", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonEditProfile.Location = new System.Drawing.Point(12, 55);
            this.buttonEditProfile.Name = "buttonEditProfile";
            this.buttonEditProfile.Size = new System.Drawing.Size(198, 71);
            this.buttonEditProfile.TabIndex = 9;
            this.buttonEditProfile.Text = "Edit Profile";
            this.buttonEditProfile.UseVisualStyleBackColor = true;
            this.buttonEditProfile.Click += new System.EventHandler(this.buttonEditProfile_Click);
            // 
            // labelUsername
            // 
            this.labelUsername.AutoSize = true;
            this.labelUsername.Font = new System.Drawing.Font("Century Gothic", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.labelUsername.Location = new System.Drawing.Point(12, 12);
            this.labelUsername.Name = "labelUsername";
            this.labelUsername.Size = new System.Drawing.Size(111, 22);
            this.labelUsername.TabIndex = 8;
            this.labelUsername.Text = "Username: ";
            // 
            // dataGridViewReservations
            // 
            this.dataGridViewReservations.AllowUserToAddRows = false;
            this.dataGridViewReservations.AllowUserToDeleteRows = false;
            this.dataGridViewReservations.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.dataGridViewReservations.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dataGridViewReservations.AutoSizeRowsMode = System.Windows.Forms.DataGridViewAutoSizeRowsMode.AllCells;
            this.dataGridViewReservations.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridViewReservations.Location = new System.Drawing.Point(216, 12);
            this.dataGridViewReservations.MultiSelect = false;
            this.dataGridViewReservations.Name = "dataGridViewReservations";
            this.dataGridViewReservations.RowHeadersVisible = false;
            this.dataGridViewReservations.RowTemplate.Height = 25;
            this.dataGridViewReservations.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridViewReservations.Size = new System.Drawing.Size(1036, 657);
            this.dataGridViewReservations.TabIndex = 7;
            // 
            // buttonViewStatus
            // 
            this.buttonViewStatus.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.buttonViewStatus.Font = new System.Drawing.Font("Century Gothic", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonViewStatus.Location = new System.Drawing.Point(12, 132);
            this.buttonViewStatus.Name = "buttonViewStatus";
            this.buttonViewStatus.Size = new System.Drawing.Size(198, 71);
            this.buttonViewStatus.TabIndex = 12;
            this.buttonViewStatus.Text = "View Status";
            this.buttonViewStatus.UseVisualStyleBackColor = true;
            this.buttonViewStatus.Click += new System.EventHandler(this.buttonViewStatus_Click);
            // 
            // buttonClose
            // 
            this.buttonClose.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.buttonClose.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.buttonClose.Font = new System.Drawing.Font("Century Gothic", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonClose.Location = new System.Drawing.Point(12, 598);
            this.buttonClose.Name = "buttonClose";
            this.buttonClose.Size = new System.Drawing.Size(198, 71);
            this.buttonClose.TabIndex = 13;
            this.buttonClose.Text = "Close";
            this.buttonClose.UseVisualStyleBackColor = true;
            this.buttonClose.Click += new System.EventHandler(this.buttonClose_Click);
            // 
            // buttonReviews
            // 
            this.buttonReviews.Anchor = System.Windows.Forms.AnchorStyles.Left;
            this.buttonReviews.Font = new System.Drawing.Font("Century Gothic", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonReviews.Location = new System.Drawing.Point(12, 286);
            this.buttonReviews.Name = "buttonReviews";
            this.buttonReviews.Size = new System.Drawing.Size(198, 71);
            this.buttonReviews.TabIndex = 14;
            this.buttonReviews.Text = "Reviews";
            this.buttonReviews.UseVisualStyleBackColor = true;
            this.buttonReviews.Click += new System.EventHandler(this.buttonReviews_Click);
            // 
            // ClientHubForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1264, 681);
            this.Controls.Add(this.buttonReviews);
            this.Controls.Add(this.buttonClose);
            this.Controls.Add(this.buttonViewStatus);
            this.Controls.Add(this.buttonMakeAReservation);
            this.Controls.Add(this.buttonEditProfile);
            this.Controls.Add(this.labelUsername);
            this.Controls.Add(this.dataGridViewReservations);
            this.Name = "ClientHubForm";
            this.Text = "ClientHubForm";
            this.Load += new System.EventHandler(this.ClientHubForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewReservations)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private Button buttonMakeAReservation;
        private Button buttonEditProfile;
        private Label labelUsername;
        private DataGridView dataGridViewReservations;
        private Button buttonViewStatus;
        private Button buttonClose;
        private Button buttonReviews;
    }
}