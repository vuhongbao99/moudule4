package com.example.quan_ly_h.controller;

@Controller
@RequestMapping("/bigs")
public class BigController {
    @Autowired
    private IBigService bigService;
    @Autowired
    private ICountryOriginService countryOriginService;


//    @GetMapping("")
//    public String findAll(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
//        int size = 5;
//        Page<Big> bigs = bigService.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "idBig")));
//        model.addAttribute("bigs", bigs);
//        model.addAttribute("countryOrigin", countryOriginService.findAll());
//        return "/index";
//    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("bigDTO", new BigDTO());
        model.addAttribute("countryOrigin", countryOriginService.findAll());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute BigDTO bigDTO, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Big big = new Big();
        BeanUtils.copyProperties(bigDTO, big);
        bigService.create(big);
        attributes.addFlashAttribute("mess", "Thêm heo thành công");
        attributes.addFlashAttribute("big", big);
        return "redirect:/bigs";
    }

    @PostMapping("/{idBig}/delete")
    public String delete(@PathVariable("idBig") String id, RedirectAttributes attributes) {
        Big big = bigService.findById(id);
        if (big != null) {
            bigService.delete(big);
            attributes.addFlashAttribute("mess", "xóa thành công");
        } else {
            attributes.addFlashAttribute("mess", "id không tim thấy");

        }
        return "redirect:/bigs";
    }

    @GetMapping("")
    public String search(@RequestParam(defaultValue = "") String keyword,
                         @RequestParam(defaultValue = "") Integer idCountry,
                         @RequestParam(name = "page", defaultValue = "0") int page, Model model, RedirectAttributes attributes) {
        int size = 3;
        int searchId;
        if (idCountry == null) {
            searchId = 0;
        } else {
            searchId = idCountry;
        }
        Page<Big> bigs = bigService.search(keyword, searchId, PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "idBig")));
        model.addAttribute("bigs", bigs);
        model.addAttribute("keyword", keyword);
        model.addAttribute("idCountry", idCountry);
        model.addAttribute("countryOrigin", countryOriginService.findAll());
        return "/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable String id, @ModelAttribute BigDTO bigDTO, RedirectAttributes attributes) {
        Big big = bigService.findById(id);
        if (big == null) {
            attributes.addFlashAttribute("mess", "không tìm thấy heo cần chỉnh sửa");
            return "redirect:/bigs";
        }
        BeanUtils.copyProperties(big, bigDTO);
        model.addAttribute("bigDTO", bigDTO);
        model.addAttribute("id", id);
        model.addAttribute("countryOrigin", countryOriginService.findAll());
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BigDTO bigDTO, BindingResult bindingResult, @RequestParam(name = "idBig") String id, Model model, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        Big big = bigService.findById(id);
        if (big == null) {
            model.addAttribute("mess", "không tìm thấy id cần thay đổi");
            return "update";
        }
        BeanUtils.copyProperties(bigDTO, big);
        bigService.update(big);
        attributes.addFlashAttribute("big", big);
        attributes.addFlashAttribute("mess", "chỉnh sửa thành công");
        return "redirect:/bigs";

    }
    @PostMapping("/delete_select")
    public String deleteSelect(@RequestParam String ids,RedirectAttributes attributes){
        List<String> stringList= Arrays.asList(ids.split(","));
        for(String id:stringList){
            Big big= bigService.findById(id);
            if(big!=null){
                bigService.delete(big);
                attributes.addFlashAttribute("mess","xóa thành công");
            }else {
                attributes.addFlashAttribute("mess","không tìm thấy mã heo cần xóa");
            }

        }
        return "redirect:/bigs";

    }

}
