package OOP2.D.MokhamadWijaya.Phipudi.controller;

import OOP2.D.MokhamadWijaya.Phipudi.entity.Hupi;
import OOP2.D.MokhamadWijaya.Phipudi.repo.HutangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.swing.text.View;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AppController {
    @Autowired
    private HutangRepo htgRepo;

    @RequestMapping("/dashboard")
    public void index(Model model){
        model.addAttribute("hupi", htgRepo.jatuhTempo());
        model.addAttribute("lunas", htgRepo.lunas());
        Object totalHutang = htgRepo.sumJumlah("hutang");
        Object totalPiutang = htgRepo.sumJumlah("piutang");
        Object jumlahAngsuran = htgRepo.countAngsuran("hutang");
        Object jumlahLunas = htgRepo.countLunas();
        Object terakhirHutang = new SimpleDateFormat().format(htgRepo.lastHupi("hutang"));
        Object terakhirPiutang = new SimpleDateFormat().format(htgRepo.lastHupi("piutang"));
        model.addAttribute("totalhutang", totalHutang);
        model.addAttribute("totalpiutang", totalPiutang);
        model.addAttribute("angsuran", jumlahAngsuran);
        model.addAttribute("totallunas", jumlahLunas);
        model.addAttribute("tanggalhutang", terakhirHutang);
        model.addAttribute("tanggalpiutang", terakhirPiutang);
    }

    @RequestMapping("/piutang")
    public void getDaftarPiutang(Model model) {
        model.addAttribute("hupi", htgRepo.findByTipeEqualsAndDeletedatIsNull("piutang"));
    }

    @RequestMapping("/hutang")
    public void getDaftarHutang(Model model) {
        model.addAttribute("hupi", htgRepo.findByTipeEqualsAndDeletedatIsNull("hutang"));
    }

    @RequestMapping(value = "/tambah-piutang", method = RequestMethod.GET)
    public void getTambahPiutang(@ModelAttribute("htn") Hupi htn, BindingResult binding) {}

    @RequestMapping(value = "/tambah-hutang", method = RequestMethod.GET)
    public void getTambahHutang(@ModelAttribute("htn") Hupi htn, BindingResult binding) {}

    @RequestMapping(value = "/tambah-piutang", method = RequestMethod.POST)
    public String saveTambahPiutang(@ModelAttribute("htn") Hupi htn, BindingResult binding) throws ParseException {
        String tanggal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Date now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(tanggal);
        htn.setCreatedat(now);
        htn.setUpdatedat(now);
        htgRepo.save(htn);
        return "redirect:/piutang";
    }

    @RequestMapping(value = "/tambah-hutang", method = RequestMethod.POST)
    public String saveTambahHutang(@ModelAttribute("htn") Hupi htn, BindingResult binding) throws ParseException {
        String tanggal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Date now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(tanggal);
        htn.setCreatedat(now);
        htn.setUpdatedat(now);
        htgRepo.save(htn);
        return "redirect:/hutang";
    }

    @RequestMapping(value = "/edithupi", method = RequestMethod.GET)
    public String getEditHupi(@RequestParam(name = "hupiid", required = false) int hupiid,
                            Model model) {
        Hupi hupi = htgRepo.findByHupiid(hupiid);
        model.addAttribute("htn", hupi);
        return "edithupi";
    }

    @RequestMapping(value = "/edithupi", method = RequestMethod.POST)
    public String saveEditHupi(@ModelAttribute("htn") Hupi htn, BindingResult binding) throws ParseException {
        String tipe = htn.getTipe();
        String tanggal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Date now = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss").parse(tanggal);
        htn.setUpdatedat(now);
        htgRepo.save(htn);
        if (tipe.equals("piutang")) {
            return "redirect:/piutang";
        } else {
            return "redirect:/hutang";
        }
    }

    @RequestMapping("/lunas")
    public String lunasHupi(@RequestParam(name = "hupiid", required = true) String hupiid) throws ParseException {
        Hupi hupi = htgRepo.findByHupiid(Integer.parseInt(hupiid));
        String tipe = hupi.getTipe();
        String tanggal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Date now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(tanggal);
        hupi.setDeletedat(now);
        htgRepo.save(hupi);
        if (tipe.equals("piutang")) {
            return "redirect:/piutang";
        } else {
            return "redirect:/hutang";
        }
    }

    @RequestMapping("/deleteHupi")
    public String deleteHupi(@RequestParam(name = "hupiid", required = true) String hupiid) {
        Hupi hupi = htgRepo.findByHupiid(Integer.parseInt(hupiid));
        String tipe = hupi.getTipe();
        htgRepo.delete(hupi);
        if (tipe.equals("piutang")) {
            return "redirect:/piutang";
        } else {
            return "redirect:/hutang";
        }

    }
}
