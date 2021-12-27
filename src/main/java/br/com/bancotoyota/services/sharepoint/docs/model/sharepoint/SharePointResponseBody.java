package br.com.bancotoyota.services.sharepoint.docs.model.sharepoint;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SharePointResponseBody {
	 @JsonProperty("__metadata")
	 private Metadata metadataObject;
	 
	 @JsonProperty("Files")
	 private Files filesObject;
	 
	 @JsonProperty("ListItemAllFields")
	 private ListItemAllFields listItemAllFieldsObject;
	 
	 @JsonProperty("ParentFolder")
	 private ParentFolder parentFolderObject;
	
	 @JsonProperty("Properties")
	 Properties propertiesObject;
	 @JsonProperty("StorageMetrics")
	 StorageMetrics StorageMetricsObject;
	 
	 @JsonProperty("Folders")
	 private Folders foldersObject;
	 
	 @JsonProperty("Exists")
	 private boolean exists;
	 
	 @JsonProperty("IsWOPIEnabled")
	 private boolean isWOPIEnabled;
	 
	 @JsonProperty("ItemCount")
	 private float ItemCount;
	 
	 @JsonProperty("Name")
	 private String name;
	 
	 @JsonProperty("ProgID")
	 private String progID = null;
	 
	 @JsonProperty("ServerRelativeUrl")
	 private String serverRelativeUrl;
	 
	 @JsonProperty("TimeCreated")
	 private String timeCreated;
	 
	 @JsonProperty("TimeLastModified")
	 private String timeLastModified;
	 
	 @JsonProperty("UniqueId")
	 private String uniqueId;
	 
	 @JsonProperty("WelcomePage")
	 private String WelcomePage;
}
