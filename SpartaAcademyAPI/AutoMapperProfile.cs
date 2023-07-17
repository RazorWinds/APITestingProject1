using AutoMapper;
using SpartaAcademyAPI.Data.DTO;
using SpartaAcademyAPI.Models;

namespace SpartaAcademyAPI
{
    public class AutoMapperProfile : Profile
    {
        public AutoMapperProfile()
        {
            CreateMap<Spartan, SpartanDTO>()
                .ForMember(dest => dest.Course, opt => opt.MapFrom(src => src.Course.Name))
                .ForMember(dest => dest.Stream, opt => opt.MapFrom(src => src.Course.Stream.Name))
                .ReverseMap();

            CreateMap<Course, CourseDTO>()
                .ForMember(dest => dest.Spartans, opt => opt.MapFrom(src => src.Spartans.Select(s => $"{s.FirstName} {s.LastName}")))
                .ForMember(dest => dest.Stream, opt => opt.MapFrom(src => src.Stream.Name))
                .ReverseMap()
                .ForMember(dest => dest.Spartans, opt => opt.Ignore()); // Ignore mapping the list of Spartans back to the Course entity

            CreateMap<Models.Stream, StreamDTO>().ReverseMap();

        }

    }
}
