package de.metas.contracts.commission.commissioninstance.businesslogic;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import de.metas.contracts.commission.commissioninstance.businesslogic.hierarchy.Hierarchy;
import de.metas.contracts.commission.commissioninstance.businesslogic.sales.commissiontrigger.CommissionTrigger;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;

/*
 * #%L
 * de.metas.contracts
 * %%
 * Copyright (C) 2019 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

@Value
@Builder
public class CreateCommissionSharesRequest
{
	@NonNull
	CommissionTrigger trigger;

	@NonNull
	@Singular
	ImmutableList<CommissionConfig> configs;

	@NonNull
	Hierarchy hierarchy;

	public CreateCommissionSharesRequest withoutConfigs(@NonNull final ImmutableSet<CommissionConfig> existingConfigs)
	{
		if (existingConfigs.isEmpty())
		{
			return this;
		}

		final ImmutableList<CommissionConfig> remainingConfigs = configs.stream()
				.filter(config -> !existingConfigs.contains(config))
				.collect(ImmutableList.toImmutableList());

		return CreateCommissionSharesRequest.builder()
				.configs(remainingConfigs)
				.trigger(trigger)
				.hierarchy(hierarchy).build();
	}
}
