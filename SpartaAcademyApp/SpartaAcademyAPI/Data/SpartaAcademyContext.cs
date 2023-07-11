using Microsoft.EntityFrameworkCore;
using SpartaAcademyAPI.Models;

namespace SpartaAcademyAPI.Data
{
    public class SpartaAcademyContext : DbContext
    {
        public SpartaAcademyContext(DbContextOptions<SpartaAcademyContext> options) : base(options) { }


        public DbSet<Spartan> Spartans { get; set; }
        public DbSet<Course> Courses { get; set; }
        public DbSet<Models.Stream> Streams { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                optionsBuilder.UseSqlServer("Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=SpartaAcademy;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
            }
        }
    }
}
