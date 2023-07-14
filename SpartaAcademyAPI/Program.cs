
using Microsoft.EntityFrameworkCore;

using SpartaAcademyAPI.Data;
using SpartaAcademyAPI.Data.Repositories;
using SpartaAcademyAPI.Models;
using SpartaAcademyAPI.Services;

var builder = WebApplication.CreateBuilder(args);
builder.Logging.ClearProviders();
builder.Logging.AddConsole();
builder.Services.AddControllers();
builder.Services.AddDbContext<SpartaAcademyContext>();
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();


var connectionString = builder.Configuration["DefaultConnection"];

//var dbConnection = builder.Configuration["DefaultConnection"];


builder.Services.AddDbContext<SpartaAcademyContext>(options =>
        options.UseSqlServer(connectionString));

builder.Services.AddAutoMapper(typeof(Program).Assembly);

builder.Services.AddScoped(                                                         
    typeof(ISpartaAcademyRepository<>),                                                 
    typeof(SpartaAcademyRepository<>));

builder.Services.AddScoped(typeof(ISpartaAcademyRepository<>), typeof(SpartaAcademyRepository<>));
builder.Services.AddScoped<ISpartaAcademyRepository<Spartan>, SpartanRepository>();
builder.Services.AddScoped<ISpartaAcademyService<Spartan>, SpartaAcademyService<Spartan>>();

builder.Services.AddControllers()
    .AddNewtonsoftJson(
    opt => opt
        .SerializerSettings
        .ReferenceLoopHandling = Newtonsoft.Json.ReferenceLoopHandling.Ignore);

var app = builder.Build();

using (var scope = app.Services.CreateScope())
{
    SeedData.Initialise(scope.ServiceProvider);
}

app.UseSwagger();
app.UseSwaggerUI();


app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
