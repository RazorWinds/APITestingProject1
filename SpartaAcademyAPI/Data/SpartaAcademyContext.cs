using Microsoft.EntityFrameworkCore;
using SpartaAcademyAPI.Models;

namespace SpartaAcademyAPI.Data
{
    public class SpartaAcademyContext : DbContext
    {

        private readonly IConfiguration _configuration;

        public SpartaAcademyContext(DbContextOptions<SpartaAcademyContext> options, IConfiguration configuration)
            : base(options)
        {
            _configuration = configuration;
        }

        public DbSet<Spartan> Spartans { get; set; }
        public DbSet<Course> Courses { get; set; }
        public DbSet<Models.Stream> Streams { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                string connectionString;
                if (Environment.GetEnvironmentVariable("ASPNETCORE_ENVIRONMENT") == "Development")
                {
                    connectionString = _configuration.GetConnectionString("DefaultConnection");
                }
                else
                {
                    connectionString = _configuration.GetConnectionString("SpartaAcademyAzureDb");
                }

                optionsBuilder.UseSqlServer(connectionString);
            }
        }
    }

}
