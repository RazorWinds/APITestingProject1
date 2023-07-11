using SpartaAcademyAPI.Models;
using System.ComponentModel.DataAnnotations.Schema;

namespace SpartaAcademyAPI.Data.DTO
{
    public class CourseDTO
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public StreamDTO Stream { get; set; } = null!;
        [ForeignKey("Stream")]
        public int StreamId { get; set; }

        //make into Trainer class
        public string Trainer { get; set; }
        public List<SpartanDTO> Spartans { get; set; } = new List<SpartanDTO>();
        public DateTime StartDate { get; set; }
        public DateTime EndDate { get; set; }

    }
}
