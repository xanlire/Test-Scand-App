package com.scand.adsense.repositories;

import com.scand.adsense.models.Campaign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, Long> {}
