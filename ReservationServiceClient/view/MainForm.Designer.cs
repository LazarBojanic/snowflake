namespace ReservationServiceClient.view {
    partial class MainForm {
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
            this.buttonRegisterAsClient = new System.Windows.Forms.Button();
            this.textBoxEmail = new System.Windows.Forms.TextBox();
            this.labelEmail = new System.Windows.Forms.Label();
            this.labelPass = new System.Windows.Forms.Label();
            this.textBoxPass = new System.Windows.Forms.TextBox();
            this.buttonLoginAsManager = new System.Windows.Forms.Button();
            this.buttonLoginAsAdmin = new System.Windows.Forms.Button();
            this.buttonLoginAsClient = new System.Windows.Forms.Button();
            this.buttonRegisterAsManager = new System.Windows.Forms.Button();
            this.labelMessage = new System.Windows.Forms.Label();
            this.buttonExit = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // buttonRegisterAsClient
            // 
            this.buttonRegisterAsClient.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonRegisterAsClient.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonRegisterAsClient.Location = new System.Drawing.Point(80, 379);
            this.buttonRegisterAsClient.Name = "buttonRegisterAsClient";
            this.buttonRegisterAsClient.Size = new System.Drawing.Size(222, 55);
            this.buttonRegisterAsClient.TabIndex = 0;
            this.buttonRegisterAsClient.Text = "Register As Client";
            this.buttonRegisterAsClient.UseVisualStyleBackColor = true;
            this.buttonRegisterAsClient.Click += new System.EventHandler(this.buttonRegisterAsClient_Click);
            // 
            // textBoxEmail
            // 
            this.textBoxEmail.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textBoxEmail.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.textBoxEmail.Location = new System.Drawing.Point(80, 55);
            this.textBoxEmail.Name = "textBoxEmail";
            this.textBoxEmail.Size = new System.Drawing.Size(222, 27);
            this.textBoxEmail.TabIndex = 1;
            // 
            // labelEmail
            // 
            this.labelEmail.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.labelEmail.AutoSize = true;
            this.labelEmail.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.labelEmail.Location = new System.Drawing.Point(166, 20);
            this.labelEmail.Name = "labelEmail";
            this.labelEmail.Size = new System.Drawing.Size(51, 21);
            this.labelEmail.TabIndex = 2;
            this.labelEmail.Text = "Email";
            this.labelEmail.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // labelPass
            // 
            this.labelPass.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.labelPass.AutoSize = true;
            this.labelPass.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.labelPass.Location = new System.Drawing.Point(150, 96);
            this.labelPass.Name = "labelPass";
            this.labelPass.Size = new System.Drawing.Size(82, 21);
            this.labelPass.TabIndex = 4;
            this.labelPass.Text = "Password";
            this.labelPass.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // textBoxPass
            // 
            this.textBoxPass.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textBoxPass.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.textBoxPass.Location = new System.Drawing.Point(80, 131);
            this.textBoxPass.Name = "textBoxPass";
            this.textBoxPass.Size = new System.Drawing.Size(222, 27);
            this.textBoxPass.TabIndex = 3;
            // 
            // buttonLoginAsManager
            // 
            this.buttonLoginAsManager.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonLoginAsManager.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonLoginAsManager.Location = new System.Drawing.Point(80, 310);
            this.buttonLoginAsManager.Name = "buttonLoginAsManager";
            this.buttonLoginAsManager.Size = new System.Drawing.Size(222, 55);
            this.buttonLoginAsManager.TabIndex = 5;
            this.buttonLoginAsManager.Text = "Login As Manager";
            this.buttonLoginAsManager.UseVisualStyleBackColor = true;
            this.buttonLoginAsManager.Click += new System.EventHandler(this.buttonLoginAsManager_Click);
            // 
            // buttonLoginAsAdmin
            // 
            this.buttonLoginAsAdmin.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonLoginAsAdmin.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonLoginAsAdmin.Location = new System.Drawing.Point(80, 172);
            this.buttonLoginAsAdmin.Name = "buttonLoginAsAdmin";
            this.buttonLoginAsAdmin.Size = new System.Drawing.Size(222, 55);
            this.buttonLoginAsAdmin.TabIndex = 7;
            this.buttonLoginAsAdmin.Text = "Login As Admin";
            this.buttonLoginAsAdmin.UseVisualStyleBackColor = true;
            this.buttonLoginAsAdmin.Click += new System.EventHandler(this.buttonLoginAsAdmin_Click);
            // 
            // buttonLoginAsClient
            // 
            this.buttonLoginAsClient.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonLoginAsClient.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonLoginAsClient.Location = new System.Drawing.Point(80, 241);
            this.buttonLoginAsClient.Name = "buttonLoginAsClient";
            this.buttonLoginAsClient.Size = new System.Drawing.Size(222, 55);
            this.buttonLoginAsClient.TabIndex = 6;
            this.buttonLoginAsClient.Text = "Login As Client";
            this.buttonLoginAsClient.UseVisualStyleBackColor = true;
            this.buttonLoginAsClient.Click += new System.EventHandler(this.buttonLoginAsClient_Click);
            // 
            // buttonRegisterAsManager
            // 
            this.buttonRegisterAsManager.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonRegisterAsManager.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonRegisterAsManager.Location = new System.Drawing.Point(80, 448);
            this.buttonRegisterAsManager.Name = "buttonRegisterAsManager";
            this.buttonRegisterAsManager.Size = new System.Drawing.Size(222, 55);
            this.buttonRegisterAsManager.TabIndex = 8;
            this.buttonRegisterAsManager.Text = "Register As Manager";
            this.buttonRegisterAsManager.UseVisualStyleBackColor = true;
            this.buttonRegisterAsManager.Click += new System.EventHandler(this.buttonRegisterAsManager_Click);
            // 
            // labelMessage
            // 
            this.labelMessage.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.labelMessage.AutoSize = true;
            this.labelMessage.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.labelMessage.Location = new System.Drawing.Point(12, 9);
            this.labelMessage.Name = "labelMessage";
            this.labelMessage.Size = new System.Drawing.Size(79, 21);
            this.labelMessage.TabIndex = 9;
            this.labelMessage.Text = "Message";
            this.labelMessage.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // buttonExit
            // 
            this.buttonExit.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonExit.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.buttonExit.Font = new System.Drawing.Font("Century Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonExit.Location = new System.Drawing.Point(80, 517);
            this.buttonExit.Name = "buttonExit";
            this.buttonExit.Size = new System.Drawing.Size(222, 55);
            this.buttonExit.TabIndex = 10;
            this.buttonExit.Text = "Exit";
            this.buttonExit.UseVisualStyleBackColor = true;
            this.buttonExit.Click += new System.EventHandler(this.buttonExit_Click);
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(386, 584);
            this.Controls.Add(this.buttonExit);
            this.Controls.Add(this.labelMessage);
            this.Controls.Add(this.buttonRegisterAsManager);
            this.Controls.Add(this.buttonLoginAsAdmin);
            this.Controls.Add(this.buttonLoginAsClient);
            this.Controls.Add(this.buttonLoginAsManager);
            this.Controls.Add(this.labelPass);
            this.Controls.Add(this.textBoxPass);
            this.Controls.Add(this.labelEmail);
            this.Controls.Add(this.textBoxEmail);
            this.Controls.Add(this.buttonRegisterAsClient);
            this.Name = "MainForm";
            this.Text = "MainForm";
            this.Load += new System.EventHandler(this.MainForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Button buttonRegisterAsClient;
        private TextBox textBoxEmail;
        private Label labelEmail;
        private Label labelPass;
        private TextBox textBoxPass;
        private Button buttonLoginAsManager;
        private Button buttonLoginAsAdmin;
        private Button buttonLoginAsClient;
        private Button buttonRegisterAsManager;
        private Label labelMessage;
        private Button buttonExit;
    }
}