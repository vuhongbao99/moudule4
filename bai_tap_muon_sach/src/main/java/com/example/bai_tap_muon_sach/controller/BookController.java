package com.example.bai_tap_muon_sach.controller;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowCodeService borrowCodeService;

    @GetMapping("")
    public String findAll(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book, RedirectAttributes attributes) {
        bookService.add(book);
        attributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/books";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable String id, Model model, RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(id);
        if (book == null) {
            redirectAttributes.addFlashAttribute("mess", "không tìm thấy sách");
            return "redirect:/books";
        }
        model.addAttribute("book", book);
        return "view";
    }

    @GetMapping("/{id}/borrow")
    public String borrow(@PathVariable String id, Model model, RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(id);
        if (book == null) {
            redirectAttributes.addFlashAttribute("mess", "không tìm thấy sách");
            return "redirect:/books";
        }
        if (book.getQuantity() <= 0) {
            redirectAttributes.addFlashAttribute("mess", "sách bạn mượn đã hết . vui lòng chọn sách khác");
            return "redirect:/books/" + id + "/view";
        }
        book.setQuantity(book.getQuantity() - 1);
        String borrowCode = bookService.randomBorrowCode();
        BorrowCode code = new BorrowCode();
        code.setBorrowCode(borrowCode);
        code.setBook(book);
        borrowCodeService.add(code);
        bookService.update(book);
        redirectAttributes.addFlashAttribute("mess", "mượn sách thành công");
        redirectAttributes.addFlashAttribute("borrowCode", code);
        return "redirect:/books/" + id + "/view";

    }

    @PostMapping("/return_code")
    public String returnBook(@RequestParam String id, Model model, RedirectAttributes redirectAttributes) {
        BorrowCode code = borrowCodeService.findByBorrowCode(id);
        if (code == null) {
            redirectAttributes.addFlashAttribute("mess", "mã mượn sách không đúng, vui lòng nhập lại");
            return "redirect:/books";
        }
        Book book = code.getBook();
        if (book == null) {
            redirectAttributes.addFlashAttribute("mess", "mã mượn sách không đúng , vui lòng nhập lại");
            return "redirect:/books";
        }
        book.setQuantity(book.getQuantity() + 1);
        bookService.update(book);
        borrowCodeService.softDelete(code);
        redirectAttributes.addFlashAttribute("mess", "trả sách thành công");
        return "redirect:/books";
    }
