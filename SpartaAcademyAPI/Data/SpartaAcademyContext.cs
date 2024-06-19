using Microsoft.EntityFrameworkCore;
using SpartaAcademyAPI.Models;

namespace SpartaAcademyAPI.Data
{
    public class SpartaAcademyContext : DbContext
    {

        private readonly IConfiguration _configuration;

        public SpartaAcademyContext(DbContextOptions<SpartaAcademyContext> options, IConfiguration configuration)
            : base(options){}

        public DbSet<Spartan> Spartans { get; set; }
        public DbSet<Course> Courses { get; set; }
        public DbSet<Models.Stream> Streams { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                optionsBuilder.UseInMemoryDatabase("SpartaAcademyDb");
            }
        }
    }

}
