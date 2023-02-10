namespace ReservationServiceClient.view {
    partial class MakeAReviewForm {
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
            this.textBoxReviewText = new System.Windows.Forms.TextBox();
            this.labelReviewText = new System.Windows.Forms.Label();
            this.dataGridViewFirms = new System.Windows.Forms.DataGridView();
            this.buttonConfirm = new System.Windows.Forms.Button();
            this.buttonClose = new System.Windows.Forms.Button();
            this.textBoxGrade = new System.Windows.Forms.TextBox();
            this.labelGrade = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewFirms)).BeginInit();
            this.SuspendLayout();
            // 
            // textBoxReviewText
            // 
            this.textBoxReviewText.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textBoxReviewText.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.textBoxReviewText.Location = new System.Drawing.Point(371, 39);
            this.textBoxReviewText.Multiline = true;
            this.textBoxReviewText.Name = "textBoxReviewText";
            this.textBoxReviewText.Size = new System.Drawing.Size(596, 455);
            this.textBoxReviewText.TabIndex = 0;
            // 
            // labelReviewText
            // 
            this.labelReviewText.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.labelReviewText.AutoSize = true;
            this.labelReviewText.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.labelReviewText.Location = new System.Drawing.Point(371, 9);
            this.labelReviewText.Name = "labelReviewText";
            this.labelReviewText.Size = new System.Drawing.Size(85, 24);
            this.labelReviewText.TabIndex = 1;
            this.labelReviewText.Text = "Review";
            // 
            // dataGridViewFirms
            // 
            this.dataGridViewFirms.AllowUserToAddRows = false;
            this.dataGridViewFirms.AllowUserToDeleteRows = false;
            this.dataGridViewFirms.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.dataGridViewFirms.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dataGridViewFirms.AutoSizeRowsMode = System.Windows.Forms.DataGridViewAutoSizeRowsMode.DisplayedCells;
            this.dataGridViewFirms.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridViewFirms.Location = new System.Drawing.Point(12, 12);
            this.dataGridViewFirms.MultiSelect = false;
            this.dataGridViewFirms.Name = "dataGridViewFirms";
            this.dataGridViewFirms.ReadOnly = true;
            this.dataGridViewFirms.RowHeadersVisible = false;
            this.dataGridViewFirms.RowTemplate.Height = 25;
            this.dataGridViewFirms.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridViewFirms.Size = new System.Drawing.Size(353, 657);
            this.dataGridViewFirms.TabIndex = 2;
            // 
            // buttonConfirm
            // 
            this.buttonConfirm.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonConfirm.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonConfirm.Location = new System.Drawing.Point(371, 601);
            this.buttonConfirm.Name = "buttonConfirm";
            this.buttonConfirm.Size = new System.Drawing.Size(126, 68);
            this.buttonConfirm.TabIndex = 3;
            this.buttonConfirm.Text = "Confirm";
            this.buttonConfirm.UseVisualStyleBackColor = true;
            this.buttonConfirm.Click += new System.EventHandler(this.buttonConfirm_Click);
            // 
            // buttonClose
            // 
            this.buttonClose.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.buttonClose.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonClose.Location = new System.Drawing.Point(841, 601);
            this.buttonClose.Name = "buttonClose";
            this.buttonClose.Size = new System.Drawing.Size(126, 68);
            this.buttonClose.TabIndex = 4;
            this.buttonClose.Text = "Close";
            this.buttonClose.UseVisualStyleBackColor = true;
            this.buttonClose.Click += new System.EventHandler(this.buttonClose_Click);
            // 
            // textBoxGrade
            // 
            this.textBoxGrade.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
            this.textBoxGrade.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.textBoxGrade.Location = new System.Drawing.Point(371, 553);
            this.textBoxGrade.Name = "textBoxGrade";
            this.textBoxGrade.Size = new System.Drawing.Size(110, 33);
            this.textBoxGrade.TabIndex = 5;
            // 
            // labelGrade
            // 
            this.labelGrade.Anchor = System.Windows.Forms.AnchorStyles.Bottom;
            this.labelGrade.AutoSize = true;
            this.labelGrade.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.labelGrade.Location = new System.Drawing.Point(371, 517);
            this.labelGrade.Name = "labelGrade";
            this.labelGrade.Size = new System.Drawing.Size(76, 24);
            this.labelGrade.TabIndex = 6;
            this.labelGrade.Text = "Grade";
            // 
            // MakeAReviewForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(979, 681);
            this.Controls.Add(this.labelGrade);
            this.Controls.Add(this.textBoxGrade);
            this.Controls.Add(this.buttonClose);
            this.Controls.Add(this.buttonConfirm);
            this.Controls.Add(this.dataGridViewFirms);
            this.Controls.Add(this.labelReviewText);
            this.Controls.Add(this.textBoxReviewText);
            this.Name = "MakeAReviewForm";
            this.Text = "MakeAViewForm";
            this.Load += new System.EventHandler(this.MakeAReviewForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewFirms)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private TextBox textBoxReviewText;
        private Label labelReviewText;
        private DataGridView dataGridViewFirms;
        private Button buttonConfirm;
        private Button buttonClose;
        private TextBox textBoxGrade;
        private Label labelGrade;
    }
}