package com.scand.adsense.services;

import com.scand.adsense.models.Campaign;
import com.scand.adsense.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    public Iterable<Campaign> getAll() {
        return campaignRepository.findAll();
    }

    public void deleteById(Long id){
        campaignRepository.delete(id);
    }

    public Campaign findById(Long id){
        return campaignRepository.findOne(id);
    }

    public void save(Long id, String name){
        campaignRepository.save(new Campaign(id, name));
    }

    public void update(Long id, String name){
        if (campaignRepository.exists(id)){
            Campaign campaign = campaignRepository.findOne(id);
            campaign.setName(name);
            campaignRepository.save(campaign);
        }
    }

    public void save(Campaign campaign){
        campaignRepository.save(campaign);
    }
}
