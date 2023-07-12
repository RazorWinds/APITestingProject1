using AutoMapper;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using SpartaAcademyAPI.Data;
using SpartaAcademyAPI.Data.DTO;
using SpartaAcademyAPI.Data.Repositories;
using SpartaAcademyAPI.Models;
using SpartaAcademyAPI.Services;

namespace SpartaAcademyAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class SpartansController : ControllerBase
    {
        private ISpartaAcademyService<Spartan> _spartanService;
        private readonly IMapper _mapper;

        public SpartansController(ISpartaAcademyService<Spartan> spartanService, IMapper mapper)
        {
            _spartanService = spartanService;
            _mapper = mapper;
        }
        [HttpGet]
        public async Task<ActionResult<IEnumerable<SpartanDTO>>> GetSpartans()
        {
            return _spartanService is null ? Problem("Entity set is null") : _mapper.Map<List<SpartanDTO>>(await _spartanService.GetAllAsync());
            
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<SpartanDTO>> GetSpartan(int id)
        {
            var spartan = await _spartanService.GetAsync(id);
            return _spartanService is null ? Problem() : spartan is null ? NoContent() : _mapper.Map<SpartanDTO>( await _spartanService.GetAsync(id));
        }

        [HttpPost]
        public async Task<ActionResult<SpartanDTO>> PostSpartan([Bind("FirstName, LastName, University, Degree, Course, Stream, Graduated")] Spartan spartan)
        {
            return await _spartanService.CreateAsync(spartan) ?

                 CreatedAtAction(
                    "GetSupplier",
                    new { id = spartan.Id },
                    _mapper.Map<SpartanDTO>(spartan)) :

             Problem("Entity set to null");
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteSpartan(int id)
        {
            return await _spartanService.DeleteAsync(id) ? NoContent() : NotFound();
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> PutSpartan(int id, [Bind("FirstName, LastName, University, Degree, Course, Stream, Graduated")] Spartan spartan)
        {
            return (id != spartan.Id) ? BadRequest() :
             (await _spartanService.UpdateAsync(id, spartan)) ? NoContent()
             : NotFound();
        }
    }
}
