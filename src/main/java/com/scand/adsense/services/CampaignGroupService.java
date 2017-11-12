package com.scand.adsense.services;

import com.scand.adsense.models.Campaign;
import com.scand.adsense.models.CampaignGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CampaignGroupService {

    @Autowired
    private CrudRepository<CampaignGroup, Long> campaignGroupRepository;

    public Iterable<CampaignGroup> getAll(){
        return campaignGroupRepository.findAll();
    }

    public void deleteById(Long id){
        campaignGroupRepository.delete(id);
    }

    public CampaignGroup findById(Long id){
        return  campaignGroupRepository.findOne(id);
    }

    public void save(Long id, String name, Campaign campaign){
        campaignGroupRepository.save(new CampaignGroup(id, name, campaign));
    }

    public void update(Long id, String name){
        if (campaignGroupRepository.exists(id)){
            CampaignGroup campaignGroup = campaignGroupRepository.findOne(id);
            campaignGroup.setName(name);
            campaignGroupRepository.save(campaignGroup);
        }
    }

}
