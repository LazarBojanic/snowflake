namespace ReservationServiceClient.view {
    partial class ManagerHubForm {
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
            this.dataGridViewFirms = new System.Windows.Forms.DataGridView();
            this.buttonCreateFirm = new System.Windows.Forms.Button();
            this.buttonUpdateFirm = new System.Windows.Forms.Button();
            this.buttonDeleteFirm = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewFirms)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridViewFirms
            // 
            this.dataGridViewFirms.AllowUserToAddRows = false;
            this.dataGridViewFirms.AllowUserToDeleteRows = false;
            this.dataGridViewFirms.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.dataGridViewFirms.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dataGridViewFirms.AutoSizeRowsMode = System.Windows.Forms.DataGridViewAutoSizeRowsMode.AllCells;
            this.dataGridViewFirms.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridViewFirms.Location = new System.Drawing.Point(12, 12);
            this.dataGridViewFirms.MultiSelect = false;
            this.dataGridViewFirms.Name = "dataGridViewFirms";
            this.dataGridViewFirms.RowHeadersVisible = false;
            this.dataGridViewFirms.RowTemplate.Height = 25;
            this.dataGridViewFirms.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridViewFirms.Size = new System.Drawing.Size(869, 657);
            this.dataGridViewFirms.TabIndex = 8;
            // 
            // buttonCreateFirm
            // 
            this.buttonCreateFirm.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonCreateFirm.Font = new System.Drawing.Font("Century Gothic", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonCreateFirm.Location = new System.Drawing.Point(1098, 12);
            this.buttonCreateFirm.Name = "buttonCreateFirm";
            this.buttonCreateFirm.Size = new System.Drawing.Size(154, 57);
            this.buttonCreateFirm.TabIndex = 9;
            this.buttonCreateFirm.Text = "Create Firm";
            this.buttonCreateFirm.UseVisualStyleBackColor = true;
            this.buttonCreateFirm.Click += new System.EventHandler(this.buttonCreateFirm_Click);
            // 
            // buttonUpdateFirm
            // 
            this.buttonUpdateFirm.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonUpdateFirm.Font = new System.Drawing.Font("Century Gothic", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonUpdateFirm.Location = new System.Drawing.Point(1098, 75);
            this.buttonUpdateFirm.Name = "buttonUpdateFirm";
            this.buttonUpdateFirm.Size = new System.Drawing.Size(154, 57);
            this.buttonUpdateFirm.TabIndex = 10;
            this.buttonUpdateFirm.Text = "Update Firm";
            this.buttonUpdateFirm.UseVisualStyleBackColor = true;
            this.buttonUpdateFirm.Click += new System.EventHandler(this.buttonUpdateFirm_Click);
            // 
            // buttonDeleteFirm
            // 
            this.buttonDeleteFirm.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonDeleteFirm.Font = new System.Drawing.Font("Century Gothic", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonDeleteFirm.Location = new System.Drawing.Point(1098, 138);
            this.buttonDeleteFirm.Name = "buttonDeleteFirm";
            this.buttonDeleteFirm.Size = new System.Drawing.Size(154, 57);
            this.buttonDeleteFirm.TabIndex = 11;
            this.buttonDeleteFirm.Text = "Delete Firm";
            this.buttonDeleteFirm.UseVisualStyleBackColor = true;
            this.buttonDeleteFirm.Click += new System.EventHandler(this.buttonDeleteFirm_Click);
            // 
            // ManagerHubForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1264, 681);
            this.Controls.Add(this.buttonDeleteFirm);
            this.Controls.Add(this.buttonUpdateFirm);
            this.Controls.Add(this.buttonCreateFirm);
            this.Controls.Add(this.dataGridViewFirms);
            this.Name = "ManagerHubForm";
            this.Text = "ManagerHubForm";
            this.Load += new System.EventHandler(this.ManagerHubForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewFirms)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private DataGridView dataGridViewFirms;
        private Button buttonCreateFirm;
        private Button buttonUpdateFirm;
        private Button buttonDeleteFirm;
    }
}