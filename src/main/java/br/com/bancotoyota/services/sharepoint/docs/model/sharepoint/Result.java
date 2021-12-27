package br.com.bancotoyota.services.sharepoint.docs.model.sharepoint;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {
	public Metadata __metadata;
	@JsonProperty("Author")
	public Author author;
	@JsonProperty("CheckedOutByUser")
	public CheckedOutByUser checkedOutByUser;
	@JsonProperty("EffectiveInformationRightsManagementSettings")
	public EffectiveInformationRightsManagementSettings effectiveInformationRightsManagementSettings;
	@JsonProperty("InformationRightsManagementSettings")
	public InformationRightsManagementSettings informationRightsManagementSettings;
	@JsonProperty("ListItemAllFields")
	public ListItemAllFields listItemAllFields;
	@JsonProperty("LockedByUser")
	public LockedByUser lockedByUser;
	@JsonProperty("ModifiedBy")
	public ModifiedBy modifiedBy;
	@JsonProperty("Properties")
	public Properties properties;
	@JsonProperty("VersionEvents")
	public VersionEvents versionEvents;
	@JsonProperty("Versions")
	public Versions versions;
	@JsonProperty("CheckInComment")
	public String checkInComment;
	@JsonProperty("CheckOutType")
	public int checkOutType;
	@JsonProperty("ContentTag")
	public String contentTag;
	@JsonProperty("CustomizedPageStatus")
	public int customizedPageStatus;
	@JsonProperty("ETag")
	public String eTag;
	@JsonProperty("Exists")
	public boolean exists;
	@JsonProperty("IrmEnabled")
	public boolean irmEnabled;
	@JsonProperty("Length")
	public String length;
	@JsonProperty("Level")
	public int level;
	@JsonProperty("LinkingUri")
	public String linkingUri;
	@JsonProperty("LinkingUrl")
	public String linkingUrl;
	@JsonProperty("MajorVersion")
	public int majorVersion;
	@JsonProperty("MinorVersion")
	public int minorVersion;
	@JsonProperty("Name")
	public String name;
	@JsonProperty("ServerRelativeUrl")
	public String serverRelativeUrl;
	@JsonProperty("TimeCreated")
	public Date timeCreated;
	@JsonProperty("TimeLastModified")
	public Date timeLastModified;
	@JsonProperty("Title")
	public String title;
	@JsonProperty("UIVersion")
	public int uIVersion;
	@JsonProperty("UIVersionLabel")
	public String uIVersionLabel;
	@JsonProperty("UniqueId")
	public String uniqueId;
	@JsonProperty("Files")
	public Files files;
	@JsonProperty("ParentFolder")
	public ParentFolder parentFolder;
	@JsonProperty("StorageMetrics")
	public StorageMetrics storageMetrics;
	@JsonProperty("Folders")
	public Folders folders;
	@JsonProperty("IsWOPIEnabled")
	public boolean isWOPIEnabled;
	@JsonProperty("ItemCount")
	public int itemCount;
	@JsonProperty("ProgID")
	public Object progID;
	@JsonProperty("WelcomePage")
	public String welcomePage;
}
