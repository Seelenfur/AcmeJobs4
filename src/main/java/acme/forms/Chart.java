
package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chart implements Serializable {

	private static final long	serialVersionUID	= 1L;

	Object[]					investorsCommonSectors;
	Object[]					companiesCommonSectors;
	Object[]					companySectors;
	Object[]					investorSectors;

	Double						ratioPublishedJobs;
	Double						ratioDraftJobs;
	Double						ratioPendingApplications;
	Double						ratioAcceptedApplications;
	Double						ratioRejectedApplications;

}
