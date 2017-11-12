package com.scand.adsense.services;

import com.scand.adsense.models.Banner;
import com.scand.adsense.models.CampaignGroup;
import com.scand.adsense.repositories.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    public Iterable<Banner> getAll(){
        return bannerRepository.findAll();
    }

    public void deleteById(Long id){
        bannerRepository.delete(id);
    }

    public Banner findById(Long id){
        return bannerRepository.findOne(id);
    }

    public void save(Long id, String data, CampaignGroup campaignGroup){
        bannerRepository.save(new Banner(id, data, campaignGroup));
    }

    public void update(Long id, String data){
        if (bannerRepository.exists(id)){
            Banner banner = bannerRepository.findOne(id);
            banner.setData(data);
            bannerRepository.save(banner);
        }
    }
}
