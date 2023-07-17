
using Microsoft.AspNetCore.Builder;
using Microsoft.EntityFrameworkCore;
using SpartaAcademyAPI;
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





builder.Services.AddDbContext<SpartaAcademyContext>();

builder.Services.AddAutoMapper(typeof(AutoMapperProfile));

// Register SpartaAcademyRepository<T> as the implementation for ISpartaAcademyRepository<T>
// This line registers the generic repository implementation for all types T
builder.Services.AddScoped(                                                         
    typeof(ISpartaAcademyRepository<>),                                                 
    typeof(SpartaAcademyRepository<>));
// Register SpartanRepository as the implementation for ISpartaAcademyRepository<Spartan>
builder.Services.AddScoped(typeof(ISpartaAcademyRepository<>), typeof(SpartaAcademyRepository<>));
// Register SpartanRepository as the implementation for ISpartaAcademyRepository<Spartan>
builder.Services.AddScoped<ISpartaAcademyRepository<Spartan>, SpartanRepository>();
// Register CourseRepository as the implementation for ISpartaAcademyRepository<Course>
builder.Services.AddScoped<ISpartaAcademyRepository<Course>, CourseRepository>();
// Register SpartaAcademyService<Spartan> as the implementation for ISpartaAcademyService<Spartan>
builder.Services.AddScoped<ISpartaAcademyService<Spartan>, SpartaAcademyService<Spartan>>();
// Register SpartaAcademyService<Course> as the implementation for ISpartaAcademyService<Course>
builder.Services.AddScoped<ISpartaAcademyService<Course>, SpartaAcademyService<Course>>();

builder.Services.AddControllers()
    .AddNewtonsoftJson(
    opt => opt
        .SerializerSettings
        .ReferenceLoopHandling = Newtonsoft.Json.ReferenceLoopHandling.Ignore);

var app = builder.Build();


if (app.Environment.IsDevelopment())
{
    using (var scope = app.Services.CreateScope())
    {
        SeedData.Initialise(scope.ServiceProvider);
    }
}


app.UseSwagger();
app.UseSwaggerUI();


app.UseHttpsRedirection();
app.UseRouting();
app.UseAuthorization();
app.UseEndpoints(endpoints =>
{
    endpoints.MapControllers();
    endpoints.MapGet("/", context =>
    {
        context.Response.Redirect("/swagger");
        return Task.CompletedTask;
    });
});


app.Run();
