package com.example.jeedemo.domain;

import java.io.Serializable;

public class WineAssociationId implements Serializable{

	private long wineId;
	
	private long customerId;
	
	public int hashCode()
	{
		return (int)(wineId + customerId);
	}
	
	public boolean equals(Object object)
	{
		if (object instanceof WineAssociationId)
		{
			WineAssociationId otherId = (WineAssociationId) object;
			return (otherId.customerId == this.customerId) && (otherId.wineId == this.wineId);
		}
		return false;
	}
}
