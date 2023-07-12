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

            CreateMap<Course, CourseDTO>().ReverseMap();
            CreateMap<StreamDTO, Models.Stream>().ReverseMap();        
    
        }

    }
}
