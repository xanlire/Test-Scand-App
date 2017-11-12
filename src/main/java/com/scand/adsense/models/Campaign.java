package com.scand.adsense.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private Set<CampaignGroup> campaignGroups;

    public Campaign(){}

    public Campaign(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Set<CampaignGroup> getCampaignGroups() {
        return campaignGroups;
    }

    public void setCampaignGroups(Set<CampaignGroup> campaignGroups) {
        this.campaignGroups = campaignGroups;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
