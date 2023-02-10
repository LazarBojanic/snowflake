namespace ReservationServiceClient.view {
    partial class ReviewsForm {
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
            this.dataGridViewReviews = new System.Windows.Forms.DataGridView();
            this.buttonMakeAReview = new System.Windows.Forms.Button();
            this.buttonSortByFirmName = new System.Windows.Forms.Button();
            this.buttonSortByFirmCity = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewReviews)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridViewReviews
            // 
            this.dataGridViewReviews.AllowUserToAddRows = false;
            this.dataGridViewReviews.AllowUserToDeleteRows = false;
            this.dataGridViewReviews.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.dataGridViewReviews.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dataGridViewReviews.AutoSizeRowsMode = System.Windows.Forms.DataGridViewAutoSizeRowsMode.DisplayedCells;
            this.dataGridViewReviews.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridViewReviews.Location = new System.Drawing.Point(12, 12);
            this.dataGridViewReviews.MultiSelect = false;
            this.dataGridViewReviews.Name = "dataGridViewReviews";
            this.dataGridViewReviews.ReadOnly = true;
            this.dataGridViewReviews.RowHeadersVisible = false;
            this.dataGridViewReviews.RowTemplate.Height = 25;
            this.dataGridViewReviews.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridViewReviews.Size = new System.Drawing.Size(560, 592);
            this.dataGridViewReviews.TabIndex = 0;
            // 
            // buttonMakeAReview
            // 
            this.buttonMakeAReview.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.buttonMakeAReview.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonMakeAReview.Location = new System.Drawing.Point(578, 12);
            this.buttonMakeAReview.Name = "buttonMakeAReview";
            this.buttonMakeAReview.Size = new System.Drawing.Size(147, 74);
            this.buttonMakeAReview.TabIndex = 1;
            this.buttonMakeAReview.Text = "Make A Review";
            this.buttonMakeAReview.UseVisualStyleBackColor = true;
            this.buttonMakeAReview.Click += new System.EventHandler(this.buttonMakeAReview_Click);
            // 
            // buttonSortByFirmName
            // 
            this.buttonSortByFirmName.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.buttonSortByFirmName.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonSortByFirmName.Location = new System.Drawing.Point(578, 92);
            this.buttonSortByFirmName.Name = "buttonSortByFirmName";
            this.buttonSortByFirmName.Size = new System.Drawing.Size(147, 74);
            this.buttonSortByFirmName.TabIndex = 4;
            this.buttonSortByFirmName.Text = "Sort By Firm Name";
            this.buttonSortByFirmName.UseVisualStyleBackColor = true;
            this.buttonSortByFirmName.Click += new System.EventHandler(this.buttonSortByFirmName_Click);
            // 
            // buttonSortByFirmCity
            // 
            this.buttonSortByFirmCity.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.buttonSortByFirmCity.Font = new System.Drawing.Font("Century Gothic", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.buttonSortByFirmCity.Location = new System.Drawing.Point(578, 172);
            this.buttonSortByFirmCity.Name = "buttonSortByFirmCity";
            this.buttonSortByFirmCity.Size = new System.Drawing.Size(147, 74);
            this.buttonSortByFirmCity.TabIndex = 5;
            this.buttonSortByFirmCity.Text = "Sort By Firm City";
            this.buttonSortByFirmCity.UseVisualStyleBackColor = true;
            this.buttonSortByFirmCity.Click += new System.EventHandler(this.buttonSortByFirmCity_Click);
            // 
            // ReviewsForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(738, 616);
            this.Controls.Add(this.buttonSortByFirmCity);
            this.Controls.Add(this.buttonSortByFirmName);
            this.Controls.Add(this.buttonMakeAReview);
            this.Controls.Add(this.dataGridViewReviews);
            this.Name = "ReviewsForm";
            this.Text = "ReviewsForm";
            this.Load += new System.EventHandler(this.ReviewsForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewReviews)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private DataGridView dataGridViewReviews;
        private Button buttonMakeAReview;
        private Button buttonSortByFirmName;
        private Button buttonSortByFirmCity;
    }
}