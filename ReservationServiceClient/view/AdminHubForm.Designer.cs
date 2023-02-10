namespace ReservationServiceClient.view {
    partial class AdminHubForm {
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
            this.dataGridViewUsers = new System.Windows.Forms.DataGridView();
            this.buttonEnableUser = new System.Windows.Forms.Button();
            this.buttonClose = new System.Windows.Forms.Button();
            this.buttonDisableUser = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewUsers)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridViewUsers
            // 
            this.dataGridViewUsers.AllowUserToAddRows = false;
            this.dataGridViewUsers.AllowUserToDeleteRows = false;
            this.dataGridViewUsers.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.dataGridViewUsers.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dataGridViewUsers.AutoSizeRowsMode = System.Windows.Forms.DataGridViewAutoSizeRowsMode.DisplayedCells;
            this.dataGridViewUsers.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridViewUsers.Location = new System.Drawing.Point(216, 12);
            this.dataGridViewUsers.MultiSelect = false;
            this.dataGridViewUsers.Name = "dataGridViewUsers";
            this.dataGridViewUsers.ReadOnly = true;
            this.dataGridViewUsers.RowHeadersVisible = false;
            this.dataGridViewUsers.RowTemplate.Height = 25;
            this.dataGridViewUsers.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridViewUsers.Size = new System.Drawing.Size(1356, 837);
            this.dataGridViewUsers.TabIndex = 0;
            // 
            // buttonEnableUser
            // 
            this.buttonEnableUser.Font = new System.Drawing.Font("Century Gothic", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonEnableUser.Location = new System.Drawing.Point(12, 59);
            this.buttonEnableUser.Name = "buttonEnableUser";
            this.buttonEnableUser.Size = new System.Drawing.Size(198, 58);
            this.buttonEnableUser.TabIndex = 1;
            this.buttonEnableUser.Text = "Enable User";
            this.buttonEnableUser.UseVisualStyleBackColor = true;
            this.buttonEnableUser.Click += new System.EventHandler(this.buttonEnableUser_Click);
            // 
            // buttonClose
            // 
            this.buttonClose.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.buttonClose.Font = new System.Drawing.Font("Century Gothic", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonClose.Location = new System.Drawing.Point(12, 778);
            this.buttonClose.Name = "buttonClose";
            this.buttonClose.Size = new System.Drawing.Size(198, 71);
            this.buttonClose.TabIndex = 12;
            this.buttonClose.Text = "Close";
            this.buttonClose.UseVisualStyleBackColor = true;
            this.buttonClose.Click += new System.EventHandler(this.buttonClose_Click);
            // 
            // buttonDisableUser
            // 
            this.buttonDisableUser.Font = new System.Drawing.Font("Century Gothic", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonDisableUser.Location = new System.Drawing.Point(12, 142);
            this.buttonDisableUser.Name = "buttonDisableUser";
            this.buttonDisableUser.Size = new System.Drawing.Size(198, 58);
            this.buttonDisableUser.TabIndex = 13;
            this.buttonDisableUser.Text = "Disable User";
            this.buttonDisableUser.UseVisualStyleBackColor = true;
            this.buttonDisableUser.Click += new System.EventHandler(this.buttonDisableUser_Click);
            // 
            // AdminHubForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1584, 861);
            this.Controls.Add(this.buttonDisableUser);
            this.Controls.Add(this.buttonClose);
            this.Controls.Add(this.buttonEnableUser);
            this.Controls.Add(this.dataGridViewUsers);
            this.Name = "AdminHubForm";
            this.Text = "AdminHubForm";
            this.Load += new System.EventHandler(this.AdminHubForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewUsers)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private DataGridView dataGridViewUsers;
        private Button buttonEnableUser;
        private Button buttonClose;
        private Button buttonDisableUser;
    }
}