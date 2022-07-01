package com.telivery.persistence.time.dto;

import com.telivery.persistence.time.entity.Time;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TimeDTO {

  private LocalDateTime openTime;
  private LocalDateTime closeTime;
  private LocalDateTime breakStartTime;
  private LocalDateTime breakEndTime;

  @Builder
  public TimeDTO(LocalDateTime openTime, LocalDateTime closeTime, LocalDateTime breakStartTime, LocalDateTime breakEndTime) {
    this.openTime = openTime;
    this.closeTime = closeTime;
    this.breakStartTime = breakStartTime;
    this.breakEndTime = breakEndTime;
  }

  public TimeDTO(Time time) {
    this.openTime = time.getOpenTime();
    this.closeTime = time.getCloseTime();
    this.breakStartTime = time.getBreakStartTime();
    this.breakEndTime =  time.getBreakEndTime();
  }

}
