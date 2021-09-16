package pdp.uz.appcodingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Language;
import pdp.uz.appcodingbat.payload.LanguageDto;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.service.LanguageService;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @PostMapping
    public Result addLanguage(@RequestBody Language language){
        Result result = languageService.addLanguage(language);
        return result;
    }

    //Delete
    @DeleteMapping(value = "/api/language/{languageId}")
    public Result deleteLanguage(@PathVariable Integer languageId) {
        Result result = languageService.deleteLanguage(languageId);
        return result;
    }

    //Update
    @PutMapping (value = "/api/languageId/{languageId}")
    public Result editLanguage(@PathVariable Integer languageId, @RequestBody LanguageDto languageDto) {
        Result result = languageService.editLanguage(languageId, languageDto);
        return result;
    }

    @GetMapping
    public List<Language> getLanguages() {
        List<Language> languages = languageService.getLanguages();
        return languages;
    }
}
