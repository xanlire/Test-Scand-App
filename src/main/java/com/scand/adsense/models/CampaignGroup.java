package com.scand.adsense.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "campaign_group")
public class CampaignGroup {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_campaign")
    private Campaign campaign;

    @OneToMany(mappedBy = "campaignGroup", cascade = CascadeType.ALL)
    private Set<Banner> banners;

    public CampaignGroup(){}

    public CampaignGroup(Long id, String name, Campaign campaign){
        this.id = id;
        this.name = name;
        this.campaign = campaign;
    }

    public Set<Banner> getBanners() {
        return banners;
    }

    public void setBanners(Set<Banner> banners) {
        this.banners = banners;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
