package com.scand.adsense.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "banner")
public class Banner {
    @Id
    @GeneratedValue
    private Long id;
    private String data;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_campaign_group", updatable = false, insertable = false, nullable = false)
    private CampaignGroup campaignGroup;

    public Banner(){}

    public Banner(Long id, String data, CampaignGroup campaignGroup){
        this.id = id;
        this.data = data;
        this.campaignGroup = campaignGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public CampaignGroup getCampaignGroup() {
        return campaignGroup;
    }

    public void setCampaignGroup(CampaignGroup campaignGroup) {
        this.campaignGroup = campaignGroup;
    }
}
