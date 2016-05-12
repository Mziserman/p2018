class WelcomeController < ApplicationController
  def home
  	@offers = Offer.where.not(published_at: nil).order(published_at: "DESC").limit(5)
  end

  def help
  end

  def about
  end
end
