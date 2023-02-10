using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

public class Rank {
    public long id { get; set; }
    public string rank { get; set; }
    public string min_number_of_days { get; set; }
    public string max_number_of_days { get; set; }

    public Rank() {
    }

    public Rank(long id, string rank, string min_number_of_days, string max_number_of_days) {
        this.id = id;
        this.rank = rank;
        this.min_number_of_days = min_number_of_days;
        this.max_number_of_days = max_number_of_days;
    }
}