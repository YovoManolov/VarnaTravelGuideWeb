package com.varnaTravelGuideWeb.model.utilModels;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document
public class WorkHours {
	
	    private Boolean is_24H;
	    @Nullable
	    private String mond_fird;
	    @Nullable
	    private String sat;
	    @Nullable
	    private String sun;
		@Override
		
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((is_24H == null) ? 0 : is_24H.hashCode());
			result = prime * result + ((mond_fird == null) ? 0 : mond_fird.hashCode());
			result = prime * result + ((sat == null) ? 0 : sat.hashCode());
			result = prime * result + ((sun == null) ? 0 : sun.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			WorkHours other = (WorkHours) obj;
			if (is_24H == null) {
				if (other.is_24H != null)
					return false;
			} else if (0 != is_24H.compareTo(other.is_24H))
				return false;
			if (mond_fird == null) {
				if (other.mond_fird != null)
					return false;
			} else if (0 != mond_fird.compareTo(other.mond_fird))
				return false;
			if (sat == null) {
				if (other.sat != null)
					return false;
			} else if (0 != sat.compareTo(other.sat))
				return false;
			if (sun == null) {
				if (other.sun != null)
					return false;
			} else if (0 != sun.compareTo(other.sun))
				return false;
			return true;
		}
	    
	    
	    
}
